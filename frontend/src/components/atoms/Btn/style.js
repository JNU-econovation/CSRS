import styled, { css } from 'styled-components';
import { Link } from 'react-router-dom';

const ButtonStyle = css`
  cursor: pointer;
  border: none;
  background: inherit;
  text-decoration: none;
  color: black;
  font-family: NanumGothic KR;
`;

export const NavBtn = styled.button`
  ${ButtonStyle}
`;
export const NavLink = styled(Link)`
  ${ButtonStyle}
  &:focus,
    &:hover,
    &:visited,
    &:link,
    &:active {
    text-decoration: none;
    color: black;
  }
`;
