FROM tomcat:latest
COPY ./build/libs/super_express_surcharge_calculation.war webapps

ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
WORKDIR $CATALINA_HOME
