import styled, { css } from 'styled-components';
import Btn from 'components/atoms/Btn';

export const NavButtonContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const NavButton = styled(Btn)`
  display: inline-block;
  font-size: 0.9rem;
  padding: 0.7em;

  white-space: nowrap;
`;
