import styled from 'styled-components';
import Text from 'components/atoms/Text';

export const CategoryGridContainer = styled.div`
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export const GuideTextContainer = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin: 5.625em;
`;

export const GuideTitle = styled(Text)`
  font-size: 2rem;
  margin-bottom: 1em;
`;

export const GuideSubTitle = styled(Text)`
  font-size: 1.375rem;
  color: #494949;
`;

export const LinkContainer = styled.div`
  width: 100%;
  margin-top: 30px;
`;
