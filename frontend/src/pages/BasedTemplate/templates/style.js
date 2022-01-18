import styled, { css } from 'styled-components';

const commonStyle = css`
  max-width: 100%;
`;

export const ChildrenWrapper = styled.div`
  ${commonStyle}
  display:flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 0;
  min-width: 800px;
  min-height: 88vh;
`;

export const HeaderWrapper = styled.div`
  display: flex;
  align-items: center;
  height: 9vh;
  ${commonStyle}
`;

export const FooterWrapper = styled.div`s
  ${commonStyle}
  height: 21vh;
  max-height: 20rem;
`;
