package calendar

class Calendar(val name:String, val owner:Owner ) {
    var active:Boolean = true

    constructor(name:String, owner: Owner, active:Boolean ) : this(name, owner) {
        this.active = active
    }
}

data class Owner(val firstname:String, val lastname:String);



