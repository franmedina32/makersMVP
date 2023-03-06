import React, { useState } from "react";
import './estilo.css'
const FuncComponente = () =>{
    const [articulos,setArticulos] = useState([]);
    const [contador, setContador] = useState(0)
    let frase = ''

    const agregarArticulo = () => {
        setContador(contador+1)
        frase = 'se agrego el articulo ' + contador
        setArticulos([...articulos, frase])
    }

    return (
        <div id="contenedor">
            <button onClick={agregarArticulo}>sumar articulo</button>
            <ul>
                {articulos.map((item, index) => (
                <li key={index} id="item">{item}</li>
                ))}
            </ul>
        </div>
    )



}

export default FuncComponente