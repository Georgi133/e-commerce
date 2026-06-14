import Button from "react-bootstrap/Button";

function OauthOptions({ isRegister }) {
    const action = isRegister ? "Sign up with" : "Sign in with";

    return (
        <div className="d-flex flex-column gap-2">
            <Button variant="outline-secondary" size="lg" className="w-100">
                {action} Google
            </Button>
            <Button variant="outline-secondary" size="lg" className="w-100">
                {action} Apple
            </Button>
            <Button variant="outline-secondary" size="lg" className="w-100">
                {action} Facebook
            </Button>
        </div>
    );
}

export default OauthOptions;
