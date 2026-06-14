import { useEffect, useState } from "react";
import Modal from "react-bootstrap/Modal";
import OauthOptions from "./OauthOptions";
import UserInput from "./UserInput";
import styles from "./Sign.module.css";

export default function Sign({ show, onClose }) {
    const [isRegister, setIsRegister] = useState(true);

    useEffect(() => {
        if (show) {
            setIsRegister(true);
        }
    }, [show]);

    return (
        <Modal show={show} onHide={onClose} centered size="lg">
            <Modal.Header closeButton>
                <Modal.Title>{isRegister ? "Register" : "Sign In"}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <div className={styles.tabRow}>
                    <button
                        type="button"
                        className={isRegister ? styles.tabActive : styles.tab}
                        onClick={() => setIsRegister(true)}
                    >
                        Register
                    </button>
                    <button
                        type="button"
                        className={!isRegister ? styles.tabActive : styles.tab}
                        onClick={() => setIsRegister(false)}
                    >
                        Sign In
                    </button>
                </div>

                <OauthOptions isRegister={isRegister} />

                <div className={styles.divider}>Or with your email</div>

                <UserInput isRegister={isRegister} />

                <button type="button" className={styles.submitBtn}>
                    {isRegister ? "Register now" : "Sign In"}
                </button>
            </Modal.Body>
        </Modal>
    );
}
