import styles from "./Home.module.css";
import { Item } from "../Item/Item";


export const Home = () => {
    return (
        <section className={styles.homeSection} id="home-section">
            <div className={styles.manContainer}>
                <h3>Men</h3>
                < Item itemId="1" picture="test.jpg" itemName="Item1" price="$100" reviews="4.5/5" />
                < Item itemId="2" picture="test.jpg" itemName="Item2" price="$150" reviews="4.0/5" />
            </div>
            <div className={styles.womenContainer}>
                <h3>Women</h3>
            </div>
            <div className={styles.childrenContainer}>
                <h3>Children</h3>
            </div>
            <div className={styles.accessoriesContainer}>
                <h3>Accessories</h3>
            </div>
        </section>
    );
}