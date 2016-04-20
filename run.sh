#/bin/sh
cd /home/sudy
echo "before mvn"
mvn clean install -Dmaven.test.skip=true
cp /home/sudy/target/EmployeeApplication.war /var/lib/tomcat7/webapps/EmployeeApplication.war
echo "after mvn"

ADMIN_USER=${ADMIN_USER:-tomcat}
ADMIN_PASS=${ADMIN_PASS:-admin}
MAX_UPLOAD_SIZE=${MAX_UPLOAD_SIZE:-82428800}
CATALINA_OPTS=${CATALINA_OPTS:-"-Xms128m -Xmx1024m -XX:PermSize=128m -XX:MaxPermSize=256m"}

export CATALINA_OPTS="${CATALINA_OPTS}"

cat << EOF > /etc/tomcat7/tomcat-users.xml
<?xml version='1.0' encoding='utf-8'?>
<tomcat-users>
<user username="${ADMIN_USER}" password="${ADMIN_PASS}" roles="admin-gui,manager-gui"/>
</tomcat-users>
EOF


/bin/sh -e /usr/share/tomcat7/bin/catalina.sh run
