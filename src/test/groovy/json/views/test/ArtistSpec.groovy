package json.views.test

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ArtistSpec extends Specification implements DomainUnitTest<Artist> {

    void "it should create a valid Artist"() {
        given:
        def oldCount = Artist.count()

        when:
        def artist = new Artist(name: "name")
        def saveResult = artist.save()

        then:
        saveResult == artist

        and:
        Artist.count() == oldCount + 1
    }

    void "it should not create an invalid Artist"() {
        given:
        def oldCount = Artist.count()

        when:
        def artist = new Artist()
        def saveResult = artist.save()

        then:
        saveResult == null

        and:
        Artist.count() == oldCount

        and:
        artist.hasErrors()
        artist.errors.allErrors.size() == 1

        and:
        def firstError = artist.errors.allErrors[0]
        firstError.arguments[0] == "name"
        "artist.name.nullable" in firstError.codes
    }

}
