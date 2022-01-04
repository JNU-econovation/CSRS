import { NavLink } from "./style";
import { BrowserRouter as Router } from "react-router-dom";

function Btn({ className, children, href }) {
    if (href) {
        return (
            <div className={className}>
                <NavLink href={href}>{children}</NavLink>
            </div>
        );
    }
    return (
        <div className={className}>
            <NavLink className={className}>{children}</NavLink>
        </div>
    );
}
export default Btn;
