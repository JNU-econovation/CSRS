import styled, { css } from "styled-components";
import { Link } from "react-router-dom";

export const NavBtn = styled.a`
    cursor: pointer;
    border: none;
    background-color: inherit;
    font-family: NanumGothic KR;
    font-size: 0.9em;
    font-weight: 500;
    &:hover {
        text-decoration: underline;
    }
`;
