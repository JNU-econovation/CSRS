import React from 'react';

import * as Styled from './style';
import Img from 'components/atoms/Img';
import MainLinkContainer from 'components/molecules/MainLinkContainer';
import { img } from 'assets/img';

function MainLink() {
  return (
    <Styled.Background>
      <Img filter={'brightness(0.3)'} alt={'배경'} src={img.MAIN_ANCHOR}></Img>
      <Styled.LinkContainer>
        <MainLinkContainer
          title={'작품 등록'}
          subtitle={'창작물을 경매에 등록해보세요'}
          alt={'작품등록'}
          to={'/register'}
          link={'작품등록'}
        />
        <MainLinkContainer
          title={'작품 검색'}
          subtitle={'카테고리를 통해 작품을 검색하세요'}
          alt={'작품검색'}
          to={'/art/new'}
          link={'작품검색'}
        />
        <MainLinkContainer
          title={'작품 구매'}
          subtitle={'창작물을 경매를 통해 구매하세요'}
          alt={'작품구매'}
          to={'/register'}
          link={'작품구매'}
        />
      </Styled.LinkContainer>
    </Styled.Background>
  );
}

export default MainLink;
