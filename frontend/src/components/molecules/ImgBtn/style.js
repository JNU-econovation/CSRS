import styled from "styled-components";

import Btn from "components/atoms/Btn";
import Img from "components/atoms/Img";

export const Button = styled(Btn)`
    display: flex;
    justify-content: center;
    align-items: center;
    border: 0;
    background: none;
    margin: 0.2rem;
    padding: 0;
    width: 20px;
`;

export const Image = styled(Img)`
    &:hover {
        transition: opacity 1s;
    }
`;
