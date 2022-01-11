import React from 'react';

import * as S from './style';
import ImgBtn from 'components/molecules/ImgBtn';
import { CATEGORY_IMG } from 'assets/img';
import { CATEGORIES } from 'common/constants/string';

const bigCategoryIdx = [2, 5];

function CategoryGrid() {
  function CategoryList(props) {
    const images = props.images;
    const listItems = images.map((image, idx) => {
      let category = CATEGORIES[idx].toLowerCase().split(' ').join('');
      if (bigCategoryIdx.includes(idx)) {
        return (
          <S.BigItem>
            <ImgBtn
              to={`/art/${category}`}
              key={category}
              src={image}
              category={CATEGORIES[idx]}
            ></ImgBtn>
          </S.BigItem>
        );
      }
      return (
        <ImgBtn
          to={`/art/${category}`}
          key={category}
          src={image}
          category={CATEGORIES[idx]}
        ></ImgBtn>
      );
    });
    return listItems;
  }

  return (
    <S.CateogryContainer>
      <CategoryList images={CATEGORY_IMG}></CategoryList>
    </S.CateogryContainer>
  );
}

export default CategoryGrid;
