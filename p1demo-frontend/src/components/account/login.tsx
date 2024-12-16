import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function Login() {

    // TODO State stuff


    // we can use the useNavigatte hook to navigate between componenet programatically
    // which means we don't have to manually hcange the URL to switch components

    const navigate = useNavigate();

    return (
        <>
            <h3> Login </h3>
            <Button onClick={() => navigate('teams')}> Login </Button>
            <Button onClick={() => navigate('register')}> Register </Button>
        </>

    );
}

export default Login;