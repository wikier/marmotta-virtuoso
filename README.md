# Experimental Virtuoso support for Apache Marmotta

This project tries to implement support to use [OpenLink Virtuoso](http://virtuoso.openlinksw.com/)
as backend for [Apache Marmotta](http://marmotta.apache.org). Although it's still
in a very experimental status.

## Installation

The library build should be fully managed with [Maven](http://maven.apache.org),
but [Virtoso Sesame](http://virtuoso.openlinksw.com/dataspace/doc/dav/wiki/Main/VirtSesame2Provider)
does not publish artifacts in a compatible way. Therefore you would need to manually
install it:

    mvn install:install-file -Dfile=virt_sesame2.jar -DgroupId=com.openlinksw.virtuoso -DartifactId=virtuoso-sesame -Dversion=2.7.0 -Dpackaging=jar
    mvn install:install-file -Dfile=virtjdbc3.jar -DgroupId=com.openlinksw.virtuoso -DartifactId=virtuoso-jdbc3 -Dversion=3.0.0 -Dpackaging=jar

After that, you should be able to normally proceed by installing the backend and
launching Marmotta as usual:

    mvn install
    cd webapp
    mvn tomcat7:run

and point your browser to http://localhost:8080

## Relationship with Marmotta

[I](http://www.wikier.org)'m committer of Apache Marmotta, so my final aim to 
contribute this code to the Apache project. But, given its current experimental 
status and the distribution issues, for the moment I prefer to keep it here.

