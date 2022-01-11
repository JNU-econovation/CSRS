import styled, { css } from 'styled-components';

export const NavBarContainer = styled.nav`
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0px 3px #ececec;
  width: max(100%, 750px);
  position: fixed;
  top: 0;
  z-index: 10;
  backgroundcolor: white;
`;

export const NavBarButtonContainer = styled.div`
  width: 50%;
  height: 9vh;
  display: flex;
  align-items: center;
  gap: 1.875rem;

  background-color: rgba(255, 255, 255, 0.7);

  backdrop-filter: blur(2px);
  ${(props) =>
    props.right &&
    css`
      justify-content: right;
    `};
  @media screen and (max-width: 950px) {
    gap: 0.5rem;
  }
`;
