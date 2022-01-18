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
  @media screen and (max-width: 768px) {
    font-size: 0.6em;
  }
`;

export const RectangleContainer = styled.div`
  width: 33%;
  position: relative;
  :after {
    content: '';
    display: block;
    padding-bottom: 100%;
  }
`;

export const BlackContainer = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: #5b5b5b;
  display: flex;
  padding: 33px;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
`;

export const Title = styled(Text)`
  font-size: 1.5rem;
  color: white;
  text-align: right;
  margin: 0.3em;
  @media screen and (max-width: 1000px) {
    font-size: 1rem;
  }
`;

export const SubTitle = styled(Text)`
  color: white;
  font-size: 0.7rem;
  @media screen and (max-width: 1000px) {
    font-size: 0.7rem;
  }
`;
