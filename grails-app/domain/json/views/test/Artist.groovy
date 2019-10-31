package json.views.test

import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Artist {
    String name

    static hasMany = [ albums: Album ]
}
