import styled, { css } from 'styled-components';

export const NavBarContainer = styled.nav`
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0px 3px #ececec;
  width: max(100%, 1100px);
  height: 70px;
`;

export const NavBarButtonContainer = styled.div`
  width: 50%;
  display: flex;
  align-items: center;
  gap: 30px;
  ${(props) =>
    props.right &&
    css`
      justify-content: right;
    `};
`;
