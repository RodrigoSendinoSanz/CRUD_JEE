/*
Librería Axios
      - Introducción, e instalación https://github.com/axios/axios
      - Basado en promesas
      - Objeto axios
      - metodo get() y post()
      - formas de enviar los datos
      - Ventajas


      Si hay muchas peticiones usar axios, si no usar fetch
*/

function cargarEventos(){
var contenido = document.querySelector(".info");


axios.get('http://localhost:4000/rest/eventos/todos')
  .then(function (response) {
    // handle success
    console.log(response.data);
    let info = response.data;
    console.log(contenido)

    for (let i = 0; i < info.length; i++) {
        
        contenido.innerHTML +=`
        <div class="card">
        <img src="https://picsum.photos/700/400" style="width:100%">
            <div class="container">
                <h4><b>${info[i].descripcion}</b></h4> 
                <p>${info[i].fechaInicio}</p>
                <a href="./info${i+1}.html"><button class="button">
                    <span>Ver más</span>
                    <div class="liquid"></div>
                    </button>
                </a>
            </div>
        </div>
        `
        
    }
    
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
  .then(function () {
    // always executed
  });

}
