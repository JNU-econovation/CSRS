import styled, { css } from 'styled-components';

export const LogoText = styled.p`
  font-size: 6rem;
  font-family: Baskervile;
  cursor: pointer;
  margin: 0;
  @media screen and (max-height: 750px) {
    font-size: 4rem;
  }
  ${(props) =>
    props.subtitle &&
    css`
      font-size: 1.875rem;
      margin-bottom: 0.3em;
      @media screen and (max-height: 750px) {
        font-size: 1rem;
      }
    `};
`;
