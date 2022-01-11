import styled from 'styled-components';

import ImgBtn from 'components/molecules/ImgBtn';
import LogoText from 'components/molecules/LogoText';
import Btn from 'components/atoms/Btn';

export const SplashContainer = styled(Btn)`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.15);
  padding: 5.375em;
  @media screen and (max-height: 750px) {
    padding: 3rem;
  }
`;

export const LogoBtn = styled(ImgBtn)`
  width: 9.25rem;
`;

export const Title = styled(LogoText)``;

export const GuideKr = styled.p`
  color: #6d6d6d;
  font-size: 1.5rem;
  margin: 0.2em;
  @media screen and (max-height: 750px) {
    font-size: 0.9rem;
  }
`;
