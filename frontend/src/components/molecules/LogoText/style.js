import styled, { css } from 'styled-components';

import Text from 'components/atoms/Text';

export const LogoText = styled(Text)`
  font-size: 6rem;
  font-family: Baskervile;
  cursor: pointer;
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
