import styled from 'styled-components';

export const Img = styled.img`
  width: ${(props) => props.width || 'inherit'};
  height: inherit;
  object-fit: inherit;
  cursor: inherit;
  filter: ${(props) => props.filter};
  color: white;
`;
