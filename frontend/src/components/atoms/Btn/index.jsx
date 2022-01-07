import { NavLink, NavBtn } from "./style";

function Btn({ className, children, href, to }) {
    if (href) {
        return (
            <NavLink className={className} to={href}>
                {children}
            </NavLink>
        );
    }
    if (to)
        <NavLink className={className} to={"/"}>
            {children}
        </NavLink>;

    return <NavBtn className={className}>{children}</NavBtn>;
}
export default Btn;
