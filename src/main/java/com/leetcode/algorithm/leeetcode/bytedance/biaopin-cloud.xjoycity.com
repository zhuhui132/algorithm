server {
    listen                   80;
    server_name              aioc.jdcloud.com;
    access_log               /export/servers/nginx/logs/biaopin-aioc/access.log jcloud;
    error_log                /export/servers/nginx/logs/biaopin-aioc/error.log warn;
 #   root 		     /home/web/web/src/;


    location / {
        rewrite ^/(.*)$ /index.html break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-web;
    }
    location /m {
        rewrite ^/m(.*)$ /index.html break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-m;
    }
    location /wx {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-wx;
    }
    
    location /nlp {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-nlp;
    }
    
    location /inspection {
        rewrite ^.*$ /inspection/ break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-inspection;
    }
    
    location /policy {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-policy/;
    }

    location ^~ /property {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-property;
    }

    location ^~ /manager {
        client_max_body_size    1000m;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-manager;
    }

    location /aioc-api {
	    rewrite ^/aioc-api(.*)$ $1 break;
	    proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-api;
    }
    
    location ^~ /sso {
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-sso;
    }

   
    location =/ {
	    proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-web;
    }


##############################复工标品
    
    location /fugong/ {
        rewrite ^/fugong(.*)$ /fugong/m/index.html break;
        proxy_pass              http://biaopin-fugong;
    }
    location ~ ^/fugong/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/fugong(.*)$ /$1/fugong/m break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-fugong;
    }

##########################标品aioc
    location ~ ^/inspection/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-inspection;
    }

    location ~ ^/policy/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        rewrite ^/policy(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-policy;
    }
    
    location ~ ^/m/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/m(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-m;
    }

##############################复工前端
    #天津复工
    location /tianjinfg/ {
        rewrite ^/tianjinfg(.*)$ /index.html break;
        proxy_pass              http://biaopin-tianjinfg;
    }
    
    location ~ ^/tianjinfg/aioc-api/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/tianjinfg/aioc-api(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tianjinfg-api;
    }
    
    location ~ ^/tianjinfg/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/tianjinfg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tianjinfg;
    }
    
    #天津楼宇信息填报
    location /tianjinBuilding/ {
        rewrite ^/tianjinBuilding(.*)$ /index.html break;
        proxy_pass              http://biaopin-tianjin-building;
    }
    location ~ ^/tianjinBuilding/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/tianjinBuilding(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tianjin-building;
    }
    #福清复工
    location /fuqingfg/ {
        rewrite ^/fuqingfg(.*)$ /index.html break;
        proxy_pass              http://biaopin-fuqingfg;
    }
    location ~ ^/fuqingfg/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/fuqingfg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-fuqingfg;
    }
     #铜梁复工
    location /tongliangfg/ {
        rewrite ^/tongliangfg(.*)$ /index.html break;
        proxy_pass              http://biaopin-tongliangfg;
    }
    location ~ ^/tongliangfg/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        rewrite ^/tongliangfg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tongliangfg;
    }
    #北海复工
    location /beihaifg/ {
        rewrite ^/beihaifg(.*)$ /index.html break;
        proxy_pass              http://biaopin-beihaifg;
    }
    location ~ ^/beihaifg/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        rewrite ^/beihaifg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-beihaifg;
    }
    #新余复工
    location /xinyufg/ {
        rewrite ^/xinyufg(.*)$ /index.html break;
        proxy_pass              http://biaopin-xinyufg;
    }
    location ~ ^/xinyufg/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        rewrite ^/xinyufg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-xinyufg;
    }
    #西安复工
    location /xianfg/ {
        rewrite ^/xianfg(.*)$ /index.html break;
        proxy_pass              http://biaopin-xianfg;
    }
    location ~ ^/xianfg/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        rewrite ^/xianfg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-xianfg;
    }
    #蚌埠复工
    location /bengbufg/ {
        rewrite ^/bengbufg(.*)$ /index.html break;
        proxy_pass              http://biaopin-bengbufg;
    }
    location ~ ^/bengbufg/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        rewrite ^/bengbufg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-bengbufg;
    }
    #黔东复工
    location /qiandongnanfg/ {
        rewrite ^/qiandongnanfg(.*)$ /index.html break;
        proxy_pass              http://biaopin-qiandongnanfg;
    }
    location ~ ^/qiandongnanfg/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm)$ {
        rewrite ^/qiandongnanfg(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-qiandongnanfg;
    }

########################## 鹤壁出入证

    #标品
    location /hebi/community {
        rewrite ^/hebi/community(.*)$ /index.html break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://hebi-community;
    }
    location ~ ^/hebi/community/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm|jpg)$ {
        rewrite ^/hebi/community(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://hebi-community;
    }

    location ~ ^/hebi-api/lesseeInfo/file/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/hebi-api/lesseeInfo/file/(.*)$  /api/lesseeInfo/file/$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://hebi-api;
    }
    location  /hebi-api/ {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://hebi-api/api/;
    }
    location ^~ /hebi-manager {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://hebi-manager;
    }
    location  ^~ /hebi-sso {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://hebi-sso;
    }
########################## 武汉出入证
    #武汉
    location /wuhan/community {
        rewrite ^/wuhan/community(.*)$ /index.html break;
        root /export/servers/wuhan-pass;
        #proxy_pass              http://wuhan-community;
    }
    location /wuhan/community/statistics {
        rewrite ^/wuhan/community(.*)$ /index.html break;
        root /export/servers/wuhan-statistics;
        #proxy_pass              http://wuhan-community;
    }
    location ~ ^/wuhan/community/statistics/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm|jpg)$ {
        expires   1h;
        rewrite ^/wuhan/community/statistics(.*)$ /$1 break;
        root /export/servers/wuhan-statistics;
        #proxy_pass              http://wuhan-community;
    }
    location ~ ^/wuhan/community/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm|jpg)$ {
        expires   1h;
        rewrite ^/wuhan/community(.*)$ /$1 break;
        root /export/servers/wuhan-pass;
        #proxy_pass              http://wuhan-community;
    }
    location ~ ^/wuhan-api/lesseeInfo/file/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/wuhan-api/lesseeInfo/file/(.*)$  /api/lesseeInfo/file/$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://wuhan-upload;
    }
    location  ~ ^/wuhan-api/lesseeInfo/upload/ {
        rewrite ^/wuhan-api/lesseeInfo/upload/(.*)$  /api/lesseeInfo/upload/$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://wuhan-upload;
    }

    location  /wuhan-api/ {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://wuhan-api/api/;
    }
    location ^~ /wuhan-manager {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://wuhan-manager;
    }
    location  ^~ /wuhan-sso {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://wuhan-sso;
    }
########################## 新乡出入证
    #新乡
    location /xinxiang/community {
        rewrite ^/xinxiang/community(.*)$ /index.html break;
        proxy_pass              http://xinxiang-community;
    }
    location ~ ^/xinxiang/community/.*\.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm|jpg)$ {
        rewrite ^/xinxiang/community(.*)$ /$1 break;
        proxy_pass              http://xinxiang-community;
    }
    location ~ ^/xinxiang-api/lesseeInfo/file/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm)$ {
        rewrite ^/xinxiang-api/lesseeInfo/file/(.*)$  /api/lesseeInfo/file/$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://xinxiang-api;
    }
    location  /xinxiang-api/ {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://xinxiang-api/api/;
    }
    location ^~ /xinxiang-manager {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://xinxiang-manager;
    }
    location  ^~ /xinxiang-sso {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://xinxiang-sso;
    }
########################## 标品aioc相关

    location /bi {
        rewrite ^/bi(.*)$ /$1 break;
        proxy_set_header  Host $host;
	    proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-bi;
    }
    
    location =/inspection {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-inspection;
    }
    
    location /inspection-api {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-inspection;
    }
    
    location =/policy {
        rewrite ^/policy(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-policy;
    }

    location /aioc-userapi {
        rewrite ^/aioc-userapi(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-userapi;
    }
    location /epidemic/ {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-epidemic;
    }
    location /community/api {
        proxy_pass              http://biaopin-community-api/api;
    }

##########################眼见后端
    location /eye/ {
        proxy_pass              http://biaopin-eye/;
    }


###########################天津复工后台
	location  /tjfgmanager/ {
	    proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tianjinfg-manager;
    }
	location ~ ^/tjfgmanager/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm|jpg)$ {
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tianjinfg-manager;
    }

    location  /tjfgsso/ {
		proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tianjinfg-sso;
    }
	location ~ ^/tjfgsso/.*\.(js|css|html|ttf|woff|png|jpg|ico|json|svg|gltf|wasm|jpg)$ {
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-tianjinfg-sso;
    }

##########################复工后端
    location  /tianjinfg/aioc-api/ {
        proxy_pass              http://biaopin-tianjinfg-api/;
    }
    location  /tongliangfg/aioc-api/ {
        proxy_pass              http://biaopin-tongliangfg-api/;
    }
    location  /beihaifg/aioc-api/ {
        proxy_pass              http://biaopin-beihaifg-api/;
    }
    location  /xinyufg/aioc-api/ {
        proxy_pass              http://biaopin-xinyufg-api/;
    }
    location  /fuqingfg/aioc-api/ {
        proxy_pass              http://biaopin-fuqingfg-api/;
    }
    location  /fugong/aioc-api/ {
        proxy_pass              http://biaopin-fugong-api/;
    }
    location  /xianfg/aioc-api/ {
        proxy_pass              http://biaopin-xianfg-api/;
    }
    location  /bengbufg/aioc-api/ {
        proxy_pass              http://biaopin-bengbufg-api/;
    }
    location  /qiandongnanfg/aioc-api/ {
        proxy_pass              http://biaopin-qiandongnanfg-api/;
    }

##########################放在最后
    location ~ \.(js|css|html|ttf|woff|png|ico|json|svg|gltf|wasm|jpg|txt)$ {
        rewrite ^/(.*)$ /$1 break;
        proxy_set_header  Host $host;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass              http://biaopin-web;
    }

}
