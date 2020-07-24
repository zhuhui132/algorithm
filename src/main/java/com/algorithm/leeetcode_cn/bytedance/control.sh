#!/bin/bash

base_dir=/export/servers
openresty_dir=$base_dir/openresty
nginx_dir=$openresty_dir/nginx
nginx_bin=$nginx_dir/sbin/nginx
nginx_domains_conf=$nginx_dir/conf/domains

source_code_base=/export/Instances/$def_app_name/$def_instance_name/runtime

log_dir=/export/Logs/$def_app_name/$def_instance_name

upstream_conf="upstream_${SKYWING_GROUP_NAME}.conf"

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
					if [[ ! -d $nginx/$dir ]]; then
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

# function : reload or start nginx
reload_nginx() {
	# if nginx is up
	if ps -ef|grep -v "grep"|grep "nginx" && ss -ntlp|grep "nginx" ;then
		$("$nginx_bin" -s reload)
		# if nginx is down
	else
		$("$nginx_bin")
	fi
}

start() {
	# create upstream.conf
	cd $source_code_base/conf/upstream
	if [[ -f $upstream_conf ]];then
		cp $upstream_conf upstream.conf
	else
		echo "$upstream_conf do not exists!"
		exit -1
	fi

    # copy conf and html
    # to do
	#\cp -fr $source_code_base/conf $nginx_dir/
	if [[ -d $source_code_base/conf ]];then
		rsync -avz --delete $source_code_base/conf $nginx_dir/
	fi
	#\cp -fr $source_code_base/html $nginx_dir/
	if [[ -d $source_code_base/html ]];then
		rsync -avz --delete $source_code_base/html $nginx_dir/
	fi
	#\cp -fr $source_code_base/lua $nginx_dir/
	if [[ -d $source_code_base/lua ]];then
		rsync -avz --delete $source_code_base/lua $nginx_dir/
	fi

	# check  nginx -t
	$("$nginx_bin" -t)

	# if check is error
	if [[ $? -ne 0 ]]; then
		# check log dir and create it if not exists
		cd $nginx_domains_conf
		for conf_file in $(ls)
		do
			check_log_dir $conf_file $nginx_dir
		done
		# check nginx -t after check log dir from domain files
		$("$nginx_bin" -t)
		if [[ $? -ne 0 ]]; then
			echo "check nginx configuration file failed!"
			exit -1
		else
			# if check is ok
			reload_nginx
		fi
	else
		# if check is ok
		reload_nginx
	fi

    echo "start"
}

stop() {
    echo "stop"

}

help() {
        echo "${0} <start|stop|restart|status>"
        exit 1
}

case "${1}" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    status|health|checkhealth)
        checkhealth
        ;;
    restart)
        stop && start
        ;;
    *)
        help
        ;;
esac

