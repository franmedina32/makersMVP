import React, { useEffect, useState } from 'react'
import {SiOpensea} from 'react-icons/si'
import {AiFillStar, AiOutlineStar} from 'react-icons/ai'
import { endpoints } from '../resources/endpoints'
const CollectionCard = (props) => {
  const [fav,setFav] = useState(false)
  const optionsBody = {
    userEmail: sessionStorage.getItem('userEmail'),
    collectionName: props.collectionData.name,
    contractAddress: props.collectionData.contract_address
  }
  const handleFavClick = () => {
    setFav(!fav)
    if (fav) {
      console.log(JSON.stringify(optionsBody))
      fetch(endpoints.deleteFav, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(optionsBody)
      })
       .then(res => res.json())
       .then(data => console.log(data)) 
    } 
    else {
      console.log(JSON.stringify(optionsBody))
      fetch(endpoints.setFav, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(optionsBody)
      })
       .then(res => res.json())
       .then(data => console.log(data))
    }
  }

  return (
    <div>
      <div>
        <div>
          <p>ADD TO FAVS</p>
          {fav ? <AiFillStar onClick={handleFavClick}/> : <AiOutlineStar onClick={handleFavClick}/>}
        </div>
        <div>
          <img src={props.collectionData.exchange_data[1].image_url} alt="" />
          <h1>{props.collectionData.name}</h1>
          <h4>token type: {props.collectionData.token_type}</h4>
          <h4>total supply: {props.collectionData.total_tokens}</h4>
          <h4>number of owners: {props.collectionData.exchange_data[1].stats.num_owners}</h4>
          <h4>market cap: {Math.floor(props.collectionData.exchange_data[1].stats.market_cap)} ETH</h4>
          <h3>LAST MONTH:</h3>
          <ul>
            <li>sales: {props.collectionData.exchange_data[1].stats.thirty_day_sales}</li>
            <li>average price: {props.collectionData.exchange_data[1].stats.thirty_day_average_price}</li>
            <li>volume: {props.collectionData.exchange_data[1].stats.thirty_day_volume}</li>
          </ul>
        </div>
        <div>
          <p>BUY ON OPEN SEA <a href={props.collectionData.exchange_data[1].exchange_url}><SiOpensea/></a></p>
        </div>
      </div>
    </div>
  )
}

export default CollectionCard