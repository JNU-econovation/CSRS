import styled from 'styled-components';

export const CateogryContainer = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr 1fr;
  gap: 5px;
`;

export const BigItem = styled.div`
  grid-column-end: span 2;
  grid-row-end: span 2;
  div {
    font-size: 2rem;
  }
`;
