import styled, { css } from 'styled-components';

export const NavBarContainer = styled.nav`
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0px 3px #ececec;
  width: max(100%, 750px);
`;

export const NavBarButtonContainer = styled.div`
  width: 50%;
  display: flex;
  align-items: center;
  gap: 1.875rem;
  ${(props) =>
    props.right &&
    css`
      justify-content: right;
    `};
  @media screen and (max-width: 950px) {
    gap: 0.5rem;
  }
`;
