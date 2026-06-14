import styles from "./Item.module.css";
import { RegularButton } from "../Button/RegularButton";
import { useState } from "react";


export function Item ({ itemId, picture, itemName, price, reviews}) {
    const [clicked, setClicked] = useState(false);

    return (
        <div className={styles.itemContainer}>
            <div className={styles.item}>
                <img src={picture} alt={itemName} />
                <h4>{itemName}</h4>
                <p>{price}</p>
                <p>Reviews {reviews}</p>
                <RegularButton text={clicked ? "Added!" : "Buy Now"} onClick={() => onBuyNow(itemId)} />
            </div>
        </div>
    );

    function onBuyNow(id) {
        console.log(`Buy now clicked for item with id: ${id}`);
        setClicked(true);  // triggers re-render → Profiler sees it
    };
}

    

