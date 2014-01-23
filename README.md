# Experimental Virtuoso support for Apache Marmotta

This project tries to implement support to use [OpenLink Virtuoso][Virtuoso]
as backend for [Apache Marmotta][Marmotta]. Although it's still
in a very experimental status.

## Usage

The library build should be fully managed with [Maven][Maven], but 
[Virtoso Sesame Provider][VSesameP]
does not publish artifacts in a compatible way. Therefore you would need to manually
[download][download] them and install it to your local maven cache:

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

Please, note that the [Virtoso Sesame Provider][VSesameP]
is published under [GNU General Public License (version 2 only)][GPL2],
and therefore requires special considerations when distributing this package.

## Relationship with Marmotta

[I](http://www.wikier.org)'m committer of Apache Marmotta, so my final aim is to 
contribute this code to the ASF project. But, given its current experimental 
status and distribution and legal issues, for the moment I'd prefer to keep 
it out of the main project.

## Acknowledgement

This work is partially funded by [Fusepool P3][Fusepool]
FP7 Project.

[Virtuoso]: http://virtuoso.openlinksw.com
[Marmotta]: http://marmotta.apache.org
[Maven]: http://maven.apache.org
[VSesameP]: http://virtuoso.openlinksw.com/dataspace/doc/dav/wiki/Main/VirtSesame2Provider
[download]: http://virtuoso.openlinksw.com/dataspace/doc/dav/wiki/Main/VOSDownload#Sesame%20Provider
[GPL2]: http://www.gnu.org/licenses/gpl-2.0.html
[Fusepool]: http://www.salzburgresearch.at/projekt/fusepool/

