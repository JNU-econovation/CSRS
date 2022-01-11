import styled, { css } from 'styled-components';

export const Text = styled.p`
  cursor: default;
  margin: ${(props) => props.margin || 0};
  font-family: NanumGothic KR;
  ${(props) =>
    props.bold &&
    css`
      font-weight: bold;
    `}
`;
