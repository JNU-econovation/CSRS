import styled from 'styled-components';

import Btn from 'components/atoms/Btn';
import Img from 'components/atoms/Img';

export const Button = styled(Btn)`
  display: flex;
  justify-content: center;
  align-items: center;
  border: 0;
  background: none;
  margin: 0.5rem;
  padding: 0;
  width: max(${(props) => props.width || '100%'}, 20px);
  font-size: 0.9em;
`;

export const Image = styled(Img)``;
