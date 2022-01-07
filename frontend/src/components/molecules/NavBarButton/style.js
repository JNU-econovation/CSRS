import styled, { css } from "styled-components";
import Btn from "components/atoms/Btn";

export const NavButtonContainer = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
`;

export const NavButton = styled(Btn)`
    padding: 0.9em;
`;
