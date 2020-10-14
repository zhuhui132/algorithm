#!/usr/bin/env bash
#! /bin/bash
set -x

nginx_dir=/export/servers/nginx
nginx_domains_conf=$nginx_dir/conf/domains
upstream_dir=$nginx_dir/conf/upstream


# function : check log dir in domain conf file and create it if not exists
# $1       : domain conf file
# $2       : nginx dir
# check_log_dir /export/servers/nginx/conf/domains/you.miniso.cn
check_log_dir (){
    domain_conf=$1
    nginx_dir=$2
	# if domain conf and log dir exist
	if [[ -f $domain_conf ]] || [[ -d $nginx_dir ]]; then
		# get dir path from domain conf file
		#dirs=$(cat $1|grep -e "access_log" -e "error_log"|awk '{print $2}'|awk -F'/' '{for(i=1;i< NF;i++){printf "%s/", $i}}')
		dirs=$(cat $1|grep -e "access_log" -e "error_log"|awk '{print $2}'|tr -d ';'|xargs -i dirname {})

		# check log dir and create it if not exist
		if [[ ! -z $dirs ]]; then
			for dir in $dirs
			do
				#if dir is a real path
				if [ "${dir:0:1}" = "/" ]; then
					if [[ ! -d $dir ]]; then
						mkdir -p $dir
					fi
				# if dir is a relative path
				else
					if [[ ! -d $nginx_dir/$dir ]]; then
						#cd $nginx_dir
						mkdir -p $nginx_dir/$dir
					fi
				fi
			done
		fi
	else
		echo "missing argument or arguments error"
		echo "check_log_dir domain_conf_file nginx_dir"
		exit -1
	fi
}

# copy source code into output
mkdir -p output
for item in `ls`
do
    if [ "$item" = "build.sh" ] || [ "$item" = "output" ] || [ "$item" = "control" ]
    then
        continue
    fi
    cp -r $item output
done

# mv control into bin dir
mkdir -p output/bin
mv control output/bin/


# check nginx conf
    # copy conf into nginx's dir
cp -r conf $nginx_dir
    # create log dir
cd $nginx_domains_conf
for conf_file in $(ls)
do
	check_log_dir $conf_file $nginx_dir
done

cd $upstream_dir

for upstream_file in $(ls *.conf)
do
    # create upstream conf
	ln -s $upstream_dir/$upstream_file $upstream_dir/upstream.conf
	# check nginx configuration syntax
	$nginx_dir/sbin/nginx -t

	if [[ $? -ne 0 ]];then
		exit -1
	fi

	# delete tmp upstream.conf
	if [ -L $upstream_dir/upstream.conf ]; then
		rm -rf $upstream_dir/upstream.conf
	fi
done

#    # cat upstream conf
#cd $nginx_dir/conf/upstream && cat *.conf > upstream.conf
#	# check nginx configuration syntax
#$nginx_dir/sbin/nginx -t
