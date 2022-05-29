package ui

data class Sitio (
    val articleId : Int, val description : String,
    val codigoDGT : String, val nombre : String,
    val comarca : String, val zona : String,
    val concejo : String, val localidad : String,
    val direccion : String, val telefono : String,
    val email : String, val facebook : String,
    val twitter : String, val instagram : String,
    val pinterest : String, val youtube : String,
    val web : String, val abiertoTodoAno : Boolean,
    val fechasCierre : String, val titulo : String,
    val texto : String, val restaurante : Boolean,
    val sidreria : String, val mesasAsturias : String,
    val sidreriaAsturias : String, val estrellaMichelin : String,
    val qdeCalidadTuristica : String, val menuCeliacos : Boolean,
    val accesibilidad : String, val iconoCategoria : String,
    val capacidad : Int, val numeroSalones : Int, val infoMascotas : String,
    val especialidades : String, val servicios : String,
    val recetas : String, val slide : String,
    val observacion : String, val masInformacion : String,
    val coordenadas : String, val datosFacilitadosPor : String,
    val categories : String, val tags : String
)