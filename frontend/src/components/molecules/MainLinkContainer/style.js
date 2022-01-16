import styled from 'styled-components';
import Btn from 'components/atoms/Btn';
import Text from 'components/atoms/Text';

export const Button = styled(Btn)`
  display: flex;
  justify-content: flex-end;
  gap: 0.4em;
  align-items: center;
  border: 0;
  background: none;
  margin: 0.5rem;
  padding: 0;
  width: max(${(props) => props.width || '100%'}, 20px);
  font-size: 0.9em;
  position: relative;
`;

export const BlackContainer = styled.div`
  width: 20rem;
  height: 20rem;
  background-color: #5b5b5b;
  display: flex;
  padding: 33px;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
`;

export const Title = styled(Text)`
  font-size: 2rem;
  color: white;
  text-align: right;
  margin: 0.3em;
`;

export const SubTitle = styled(Text)`
  color: white;
  font-size: 1.125em;
`;
