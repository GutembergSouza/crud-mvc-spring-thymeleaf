function remover(id){



    async function loadMovies(){

        var requestHeaderUri = "https://api.themoviedb.org/4/list/"+list_id+"?api_key="+api_key+"&page=1&language=pt-BR"
        var requestAuthorization = "Bearer " + api_tokken;
        var data = JSON.stringify({});
        var xhr = new XMLHttpRequest();

        xhr.withCredentials = false;
        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === this.DONE) {

                var response = this.response
                var responseJson = JSON.parse(response)
                var arrFilmes = responseJson.results
                console.log(arrFilmes)

                filmes = document.getElementById("filmes")

                for(let i=0; i< arrFilmes.length; i++){

                    let posterPath = arrFilmes[i]["poster_path"]
                    var imgUrl = baseUrlImg+posterPath;


                    filme = document.createElement('img')
                    filme.className = "swiper-slide"
                    filme.src = `${imgUrl}`
                    filmes.appendChild(filme)

                }
            }
        });

        xhr.open("GET", requestHeaderUri);
        xhr.setRequestHeader("content-type", "application/json;charset=utf-8");
        xhr.setRequestHeader("authorization", requestAuthorization);
        xhr.send(data);

    }
}