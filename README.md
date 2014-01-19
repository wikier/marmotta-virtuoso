# Experimental Virtuoso support for Apache Marmotta

This project tries to implement support to use [OpenLink Virtuoso](http://virtuoso.openlinksw.com/)
as backend for [Apache Marmotta](http://marmotta.apache.org). Although it's still
in a very experimental status.

## Usage

The library build should be fully managed with [Maven](http://maven.apache.org), but 
[Virtoso Sesame Provider](http://virtuoso.openlinksw.com/dataspace/doc/dav/wiki/Main/VirtSesame2Provider)
does not publish artifacts in a compatible way. Therefore you would need to manually
install it:

    mvn install:install-file -Dfile=virtjdbc4.jar -DgroupId=com.openlinksw.virtuoso -DartifactId=virtuoso-jdbc4 -Dversion=4.0.0 -Dpackaging=jar
    mvn install:install-file -Dfile=virt_sesame2.jar -DgroupId=com.openlinksw.virtuoso -DartifactId=virtuoso-sesame -Dversion=2.7.0 -Dpackaging=jar

After that, you should be able to normally proceed by installing the backend and
launching Marmotta as usual:

    mvn install
    cd webapp
    mvn tomcat7:run

and point your browser to [localhost:8080](http://localhost:8080)

By default the backend expects to access Virtuoso on `localhost:1111`
with the default credentials, but you can customize that from the 
backend settings.

Please, note that the [Virtoso Sesame Provider](http://virtuoso.openlinksw.com/dataspace/doc/dav/wiki/Main/VirtSesame2Provider)
is published under GNU General Public License (version 2 only), and therefore 
requires special considerations when distributing this package.

## Relationship with Marmotta

[I](http://www.wikier.org)'m committer of Apache Marmotta, so my final aim is to 
contribute this code to the ASF project. But, given its current experimental 
status and distribution and legal issues, for the moment I'd prefer to keep 
it out of the main project.

## Acknowledgement

This work is partially funded by [Fusepool P3](http://www.salzburgresearch.at/projekt/fusepool/)
FP7 Project.

