import Form from "react-bootstrap/Form";
import styles from "./UserInput.module.css";

export default function UserInput({ isRegister }) {
    return (
        <Form className={styles.form}>
            {isRegister && (
                <div className={styles.nameRow}>
                    <Form.Control placeholder="First name" aria-label="First name" />
                    <Form.Control placeholder="Last name" aria-label="Last name" />
                </div>
            )}
            <Form.Control type="email" placeholder="Email address" aria-label="Email address" />
            <Form.Control
                type="password"
                placeholder={isRegister ? "Password (min. 6 characters)" : "Password"}
                aria-label="Password"
            />
        </Form>
    );
}
