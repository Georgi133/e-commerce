import styles from "./Button.module.css";

export const RegularButton = ({ text, onClick }) => {
    return (
        <button onClick={ onClick } type="submit" className={styles.regularButton}>
            {text}
          </button>
    );
}