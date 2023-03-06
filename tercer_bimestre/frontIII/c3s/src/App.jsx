import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import boredApe from './assets/boredApe.png'

function App() {
  const [count, setCount] = useState(0)

 return (
  <div className = "App">
    <h1>Hola pa!</h1>
    <ul>
      <li>Java</li>
      <li>Spring</li>
      <li>React</li>
      <li>Solidity</li>
    </ul>
    <img src={"reactLogo"}/>
  </div>
  )
}

export default App
