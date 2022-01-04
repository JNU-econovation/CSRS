import styled, { css } from "styled-components";
import { Link } from "react-router-dom";

export const NavLink = styled.a`
    cursor: pointer;
    border: none;
    background: ${(props) => props.img || "inherit"};
    font-family: NanumGothic KR;
    font-size: 0.9em;
    font-weight: 500;
    margin: 2rem;
    &:hover {
        text-decoration: underline;
    }
`;
