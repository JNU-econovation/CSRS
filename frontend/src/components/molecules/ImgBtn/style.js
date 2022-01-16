import styled, { css } from 'styled-components';

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
  position: relative;
  ${(props) =>
    props.category &&
    css`
      margin: 0;
    `}
`;

export const Image = styled(Img)``;

export const Category = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: black;
  opacity: 0;
  font-size: 1rem;
  color: white;
  transition: 0.5s;
  text-align: center;
  &:hover {
    opacity: 0.7;
  }
`;
