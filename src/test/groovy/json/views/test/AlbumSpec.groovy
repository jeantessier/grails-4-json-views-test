package json.views.test

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AlbumSpec extends Specification implements DomainUnitTest<Album> {

    void "it should create a valid Album"() {
        given:
        def oldCount = Album.count()

        when:
        def album = new Album(title: "title")
        def saveResult = album.save()

        then:
        saveResult == album

        and:
        Album.count() == oldCount + 1
    }

    void "it should not create an invalid Album"() {
        given:
        def oldCount = Album.count()

        when:
        def album = new Album()
        def saveResult = album.save()

        then:
        saveResult == null

        and:
        Album.count() == oldCount

        and:
        album.hasErrors()
        album.errors.allErrors.size() == 1

        and:
        def firstError = album.errors.allErrors[0]
        firstError.arguments[0] == "title"
        "album.title.nullable" in firstError.codes
    }

}
