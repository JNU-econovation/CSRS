import React from "react";

import * as Styled from "./style";

function ImgBtn({ src, alt, ...props }) {
    return (
        <Styled.Button {...props} width="20px">
            <Styled.Image alt={alt} src={src} />
        </Styled.Button>
    );
}

export default ImgBtn;
