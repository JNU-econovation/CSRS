import styled from 'styled-components';

export const Img = styled.img`
  width: ${(props) => props.width || 'inherit'};
  height: inherit;
  object-fit: inherit;
  cursor: pointer;
  filter: ${(props) => props.filter};
  color: white;
`;
