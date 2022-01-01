import { NavBtn } from "./style";
import { BrowserRouter as Router } from "react-router-dom";

function Btn({ children }) {
    return (
        <Router>
            <NavBtn>{children}</NavBtn>
        </Router>
    );
}
export default Btn;
