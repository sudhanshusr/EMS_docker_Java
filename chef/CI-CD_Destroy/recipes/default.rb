#
# Cookbook Name:: CI-CD_Destroy
# Recipe:: default
#
# Copyright (c) 2015 The Authors, All Rights Reserved.

package [ 'openjdk-7-jdk', 'mysql-server', 'maven', 'tomcat7'] do 
#package [ 'openjdk*', 'mysql*', 'maven', 'tomcat*'] do 
	action :remove
end

execute "apt-get autoclean"
execute "apt-get autoremove -y"

file "/root/slave.jar" do 
	action :delete
end

#[ /opt/vijeta-jenkins/ /root/.m2 /root/.jenkins ].each do |path|
directory "/opt/vijeta-jenkins/" do
	action :delete
	recursive true
end
directory "/root/.m2/" do
	action :delete
	recursive true
end
directory "/root/.jenkins/" do
	action :delete
	recursive true
end
#execute "rm -rf '/opt/vijeta-jenkins/ /root/.m2 /root/.jenkins'"


directory '/opt/vijeta-jenkins/'

#killer=`ps -aux | grep Chef-CI-CD | grep -v grep | awk '{print $2}'`

#execute "kill -9 #{killer}"

#execute 'reboot'

log 'message' do
	message '
	
			 I am done with all the required Tasks. 
			 I will meet You for your Next Deployment
				____               ____
				| __ ) _   _  ___  | __ ) _   _  ___
				|  _ \| | | |/ _ \ |  _ \| | | |/ _ \
				| |_) | |_| |  __/ | |_) | |_| |  __/
				|____/ \__, |\___| |____/ \__, |\___|
					|___/              |___/
			 
'
	level :warn
end