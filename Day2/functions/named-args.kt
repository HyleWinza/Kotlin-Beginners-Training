fun main (args : Array<String>)
{
   family();
   family(f = "Gideon");
   family(m = "Esther");
   family(c = "Juma na Roza");
   family(f = "Manenge", m = "Mandawa");
   family(f = "Salim", m = "Salama", c = "Khamis and Abdallah");
}

fun family(f: String = "Mr. Daudi", m:String = "Mrs. Daudi", c: String = "Neema, Musa and Baraka") : Unit
{
    println("Father is $f, mother is $m and children $c")
}
